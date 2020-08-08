(ns coffee-funnel.core
  (:require [scad-clj.scad :as scad]
            [scad-clj.model :as m]))

(defn funnel-vary-thickness
  "Makes a funnel. From & to are radii measured OD."
  [{:keys [from to height from-thickness to-thickness]}]
  (let [rs [from to]
        top-rs [(- from from-thickness) (- to to-thickness)]]
    (m/difference
     (m/cylinder rs height)
     (m/cylinder top-rs height))))

(defn hollow-cylinder [inner-r height thickness]
  (m/difference
   (m/cylinder inner-r height)
   (m/cylinder (- inner-r thickness) height)))

(defn build []
  (spit
   "funnel.scad"
   (let [small-extension-height 4
         big-extension-height 10
         lucca (+ (/ 53 2) 0.25) ;; 0.25 experimentally measured fine adjustment value
         standard (/ 59 2)
         funnel-height 30
         thickness 4
         lucca-side-thickness 2]
     (scad/write-scad
      (m/with-fn 120
        (m/with-center false
          (m/union
           (m/translate
            [0 0 funnel-height] (hollow-cylinder lucca small-extension-height lucca-side-thickness))
           (funnel-vary-thickness
            {:from (+ standard thickness)
             :to lucca
             :height funnel-height
             :from-thickness thickness
             :to-thickness lucca-side-thickness})
           (m/translate
            [0 0 (- big-extension-height)] (hollow-cylinder (+ standard thickness) big-extension-height thickness)))))))))

(build)