(ns four-clojure.week4)

;; Template
;;;;;;;;;;;;;;;;;;;;;;
;; #
;; input:
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;


;; command-opt-L reformat code

;;;;;;;;;;;;;;;;;;;;;;;; Week 4 ;;;;;;;;;;;;;;;;;;;;;;;;;



;;;;;;;;;;;;;;;;;;;;;;
;; Update on #38 Maximum value
;; input (=  (__ 1 8 3 4) 8 )
;; result: none of these work, brackets can't match, not passed
;;;;;;;;;;;;;;;;;;;;;;

((fn [& args] (first (sort > args))) 1 8 3 4)



;;;;;;;;;;;;;;;;;;;;;;
;; #28 Flatten a Sequence
;; input: (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;; result: passed
;;;;;;;;;;;;;;;;;;;;;;

