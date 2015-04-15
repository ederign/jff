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

