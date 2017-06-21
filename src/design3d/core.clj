(ns design3d.core
  (:use [scad-clj.scad])
  (:use [scad-clj.model]))

(def like-heart 
  (union
    (->> (cylinder 100 100)
         (translate [100 75 0]))
    (->> (cylinder 100 100)
         (translate [250 75 0]))
    (->> (cube 200 200 100)
         (rotate (/ Math/PI 4) [0 0 1])
         (translate [175 0 0]))))
  
  
(def poli
  (union
    (->> (polyhedron [[0 -10 60] [0 10 60] [0 10 0] [0 -10 0] [60 -10 60] [60 10 60]]
           [[0 3 2] [0 2 1] [3 0 4] [1 2 5] [0 5 4] [0 1 5] [5 2 4] [4 2 3]])
        (rotate (/ Math/PI 2) [0 0 1]))))

(def draw-mickey
  (union
    (sphere 100)
    (->> (sphere 50)
         (color [0.533 0.176 0.376 1])
         (translate [90 0 90]))
    (->> (sphere 50)
         (color [0.533 0.176 0.376 1])
         (translate [-90 0 90]))
    (->> (sphere 50)
         (color [0.153 0.337 0.42 1])
         (translate [0 70 -20]))
    (->> (sphere 10)
         (color [0.153 0.337 0.42 1])
         (translate [0 120 -10]))
    (->> (cylinder 15 20)
         (color [0.153 0.337 0.42 1])
         (rotate (/ Math/PI 2) [3 1 0])
         (translate [-40 85 30]))
    (->> (cylinder 15 20)
         (color [0.153 0.337 0.42 1])
         (rotate (/ Math/PI 2) [-3 1 0])
         (translate [40 85 30]))))     
  
(defn heart-coords []
  (for [t (range (-(Math/PI)) (Math/PI) 0.01)] 
    (let [x (* 16 (Math/pow (Math/sin t) 3))
          y (- (* 13 (Math/cos t)) 
               (* 5 (Math/cos (* 2 t))) 
               (* 2 (Math/cos (* 3 t))) 
               (Math/cos (* 4 t)))
          z 0
          tp (/ (+ t 3) 6.1)
          r (Math/sin (* tp Math/PI))
          g 0
          b 0]
      (union
        (->> (sphere 2)
             (color [r g b 1])
             (translate [x y z]))))))


(spit "post-demo.scad"
  (write-scad draw-mickey))



