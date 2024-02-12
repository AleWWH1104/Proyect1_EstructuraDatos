(
    defun fibonacci (num)
        (if (= num 0) 0
            (if (= num 1) 1
                (+ (fibonacci (- num 2)) (fibonacci (- num 1)))
            )
        )
)

(print (fibonacci 6))