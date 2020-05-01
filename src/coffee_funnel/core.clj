(ns coffee-funnel.core
  (:require [scad-clj.scad :as scad]
            [scad-clj.model :as m]))


(defn funnel [from to height thickness]
  (let [rs [from to]]
    (m/difference
     (m/cylinder (mapv #(+ thickness %) rs) height)
     (m/cylinder rs height))))

(defn hollow-cylinder [inner-r height thickness]
  (m/difference
   (m/cylinder (+ thickness inner-r) height)
   (m/cylinder inner-r height)))

(defn build []
  (spit
   "funnel.scad"
   (let [small-extension-height 7
         big-extension-height 10
         lucca (/ 53 2)
         standard (/ 59 2)
         thickness 4]
     (scad/write-scad
      (m/with-fn 120
        (m/with-center false
          (m/union
           (m/translate
            [0 0 10] (hollow-cylinder (- lucca thickness) small-extension-height thickness))
           (funnel standard (- lucca thickness) 10 thickness)
           (m/translate
            [0 0 (- big-extension-height)] (hollow-cylinder standard big-extension-height thickness)))))))))

(build)