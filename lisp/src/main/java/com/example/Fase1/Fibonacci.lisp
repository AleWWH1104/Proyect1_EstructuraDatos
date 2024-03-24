(defun fibonacci (n)
  (cond
    ((= n 0) 0)
    ((= n 1) 1)
    ((> n 1) (+ (fibonacci (- n 1)) (fibonacci (- n 2))))))

;; Probemos la función con algunos valores
(print (fibonacci 0)) ;=> 0
(print (fibonacci 1)) ;=> 1
(print (fibonacci 2)) ;=> 1
(print (fibonacci 3)) ;=> 2
(print (fibonacci 4)) ;=> 3
(print (fibonacci 5)) ;=> 5
(print (fibonacci 6)) ;=> 8
(print (fibonacci 7)) ;=> 13
