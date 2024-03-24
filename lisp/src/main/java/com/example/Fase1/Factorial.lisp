(
    defun factorial (num)
        (if (= num 0) 
        (* num (factorial (- num )))
        )
)

(print (factorial ))
