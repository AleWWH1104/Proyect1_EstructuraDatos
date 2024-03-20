(setq x (+ 1 2))
(defun factorial (n)
  (if (= n 0) ; Si n es igual a 0
      1        ; Devuelve 1 (caso base)
      (* n (factorial (- n 1))))) ; De lo contrario, multiplica n por el factorial de n-1




(print (factorial x))
