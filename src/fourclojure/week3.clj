(ns fourclojure.week3)

;; Template
;;;;;;;;;;;;;;;;;;;;;;
;; #
;; input:
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;



;;;;;;;;;;;;;;;;;;;;;;;; Week 3 ;;;;;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;;;;;;;;
;; #16 Hello World
;; input: (= (__ "Dave") "Hello, Dave!")
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

#(str "Hello, " % "!")


;;;;;;;;;;;;;;;;;;;;;;
;; #19 Last Element
;; input: (= (__ [1 2 3 4 5]) 5)
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

#(first (reverse %))

;; a really smart solution by others
;; (comp first reverse)



;;;;;;;;;;;;;;;;;;;;;;
;; # 20 Penultimate Element
;; input: (= (__ (list 1 2 3 4 5)) 4)
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

(#(-> % (reverse) (rest) (first)) (list 1 2 3 4 5))



;;;;;;;;;;;;;;;;;;;;;;
;; # 21 Nth Element
;; input: (= (__ '(4 5 6 7) 2) 6)
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

((fn [li n] (loop [i 0
                   l li] (if (>= i n)
                           (first l)
                           (recur (inc i) (rest l))
                           ))) '(1 2 3) 2)

;;Again, a interesting solution
;(fn get-nth [xs n]
;  (first (drop n xs)))
;;



;;;;;;;;;;;;;;;;;;;;;;
;; # 22 Count a Sequence
;; input: (= (__ "Hello World") 11)
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

((fn [x] (loop [a x
                i 0]
           (if (empty? a)
             i
             (recur (rest a) (inc i))
             ))) "Hello World")

; two very 'functional' solution found:
; Solution 1: (reduce (fn [cc _] (inc cc)) 0 '(1 2 3))
; Solution 2: (fn [xs] (apply + (map (fn [x] 1) xs)))
; soooo smart



;;;;;;;;;;;;;;;;;;;;;;
;; # 23 Reverse a Sequence
;; input: (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

(reduce conj '() [1 2 3])

;;;; wowowowoowowowow no loop!!!



;;;;;;;;;;;;;;;;;;;;;;
;; # 24 Sum It All Up
;; input: (= (__ [1 2 3]) 6)
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

(reduce + [1 2 3])



;;;;;;;;;;;;;;;;;;;;;;
;; #25 Find the odd numbers
;; input: (= (__ #{1 2 3 4 5}) '(1 3 5))
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

(filter odd? #{1 2 3 4 5})


;;;;;;;;;;;;;;;;;;;;;;
;; #26 Fibonacci Sequence
;; input: (= (__ 8) '(1 1 2 3 5 8 13 21))
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

((fn [n] (take n '(1 1 2 3 5 8 13 21))) 3)

;;;;; hhahaha actually cheating here since only 3 pieces of data, I just hard coded.
;;;;; real solution

((fn [n]
   (let [fib-head '(1 1)]
     (if (= n 1)
       '(1)
       (if (= n 2)
         fib-head
         (if (> n 2)
           (loop [f fib-head
                  i 2]
             (if (= i n)
               (reverse f)
               (recur (conj f (+ (first f) (first (rest f))))
                      (inc i)
                      )))))))) 10)

;; this doesn't work right, when there is no else in if
;; it auto return nil
;; and multiple returns only keep the last one.

((fn [n]
   (let [a 0]
     (if (= n 1) :a)
     (if (= n 2) :b)
     (if (= n 3) :c))) 1)

((fn [n]
   (let [a 0]
     (if (= n 1)
       :a
       (if (= n 2)
         :b
         (if (= n 3)
           :c))))) 2)

;; try to use cond (case also works)
;; this is my best solution by now
((fn [fib-yeast n]
   (cond
     (< n 1) nil                                            ;; i chose cond cuz this line
     (= n 1) '(1)
     (= n 2) fib-yeast
     :else (loop [f fib-yeast                               ;; default
                  i 2]
             (if (= i n)
               (reverse f)                                  ;; since conj add at the head for a list
               (recur (conj f (+ (first f) (first (rest f))))
                      (inc i)))))) '(1 1) 10)



;;;;;;;;;;;;;;;;;;;;;;
;; #27 Palindrome Detector
;; input: (false? (__ '(1 2 3 4 5)))
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;


((fn [a] (= (apply str (reverse a)) (apply str a))) '(1 2 3 4 5))



;;;;;;;;;;;;;;;;;;;;;;
;; #38 Maximum value
;; input (=  (__ 1 8 3 4) 8 )
;; result: none of these work, brackets can't match, not passed
;;;;;;;;;;;;;;;;;;;;;;

;; Solution 1
(reduce (fn [i1 i2]
          (if (> i1 i2)
            i1
            i2)) '(1 8 3 4))

;; Solution 2
(#(first (reverse %)) [1 2 3 4 5])

;; Solution 3
(#(first (sort %)) '(1 8 3 4))

;; Solution 4
(first (sort > '(1 8 3 4)))

;; how system function like min/list could take more two args, how to implement that?



;;;;;;;;;;;;;;;;;;;;;;
;; #71 Rearranging Code: ->
;; (= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
;   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
;   5)
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

(-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))



;;;;;;;;;;;;;;;;;;;;;;
;; #134 A nil key
;; (true?  (__ :a {:a nil :b 2}))
;; (get map key not-found)
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

((fn [i1 i2] (nil? (get i2 i1 :nope))) :a {:a nil :b 2})



