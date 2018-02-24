 (ns day23)

(def direction [
    [  1  0 ]
    [  0  1 ]
    [ -1  0 ]
    [  0 -1 ]
])

(direction 1)


(defn move [location heading]
      [ (+ (first location) (first (nth direction (mod heading 4))))
        (+ (second location) (second (nth direction (mod heading 4))))])

(mod 9 3)

(move [3 3] 0)
(move [3 3] 1)
(move [3 3] 2)
(move [3 3] 3)

(= (* 2 1.0) (* 4 0.5))
(mod 7 4)
(def endpoint 5)

;;'(1 2 3 5 7 10 13 17 21 26 31 37 43 50 57)
;; '(  1 1 2 2  3  3  4  4  5  5  6  6  7  7

(loop [
        counter 1
        current-coordinates [0 0]
        heading 0
        submovement 0
        submovement-treshold 1
        submovement-treshold-times 0
        ]
  (if (= counter 4)
    current-coordinates
    (recur
      (inc counter)                      ;; counter
      (move current-coordinates heading) ;; coordinates
      (if (= submovement submovement-treshold) ;;heading
        (mod (inc heading) 4)
         heading)
      (if (= submovement submovement-treshold)
        0
        (inc submovement))
      (if (and       
            (= submovement-treshold-times 1) 
            (= submovement submovement-treshold)) 
          (inc submovement-treshold)
          submovement-treshold)
      (if (= submovement submovement-treshold)
        (mod (inc submovement-treshold-times) 2)
        submovement-treshold-times))))

