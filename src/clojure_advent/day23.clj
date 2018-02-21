(def direction {
    :right [1 0]
    :up [0 1]
    :left [-1 0]
    :down [0 -1]
})

(def k 1)

(def endpoint 15)

(loop [
        counter 1
        current-coordinates [0 0]
        movement (:right direction)
        scalar 1
        increase-scalar 0]
  (if (= counter endpoint)
    current-coordinates
    recur ((inc counter)
           (move current-coordinates movement)
           (mod) 
    
  
(defn move [location heading]
      [ (+ (first location) (first (direction heading))) 
        (+ (second location) (second (direction heading)))])
  

  
(move [3 3] :up)
(move [3 3] :up)
(move [3 3] :right)
(move [3 3] :left)


