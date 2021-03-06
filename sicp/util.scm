(define (abs x)
	(cond (( < x 0) (- x))
			(else x))) 

(define (square x)
	(* x x)) 

(define (sum-of-squares x y)
	(+ (square x) (square y)))

(define  
     (larger x y)  
         (if (> x y) x y))

(define (f a)
	(sum-of-squares (+ a 1)(* a 2)))


(define (new-if predicate then-clause else-clause)
	(cond (predicate then-clause)
		  (else else-clause)))