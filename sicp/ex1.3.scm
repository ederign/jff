 (define (sum-of-squared-largest-two x y z) 
         (cond ((= (min x y z) x) (sum-of-squares y z)) 
               ((= (min x y z) y) (sum-of-squares x z)) 
               ((= (min x y z) z) (sum-of-squares x y)))) 