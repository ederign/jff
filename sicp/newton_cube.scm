(load "util.scm")
(define (cube x)
	(* x x x))
(define (improve guess x)
	(/ (+ (/ x (square guess)) (* 2 guess) ) 3))
(define (good-enough? guess x)
	(< (abs (- (cube guess) x)) 0.001))
(define (cubed_root-iter guess x)
	(if (good-enough? guess x)
		guess
		(cubed_root-iter (improve guess x)
			x)))
(define (cubed_root x)
	(cubed_root-iter 1.0 x))
