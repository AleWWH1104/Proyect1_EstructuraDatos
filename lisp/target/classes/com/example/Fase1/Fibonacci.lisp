(
    defun fibonacci (num)
        (if (= num 0) 0
            (if (= num ) 
                (+ (fibonacci (- num 2)) (fibonacci (- num )))
            )
        )
)

(print (fibonacci 6))
