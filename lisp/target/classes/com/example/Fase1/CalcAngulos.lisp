;; Función para convertir grados a radianes
(defun grados-radianes (grados)
  (* grados (/ pi 80)))

;; Ingresar un ángulo en grados
(format t "Ingrese un ángulo en grados: ")
(finish-output)
(let ((angulo (read)))
  ;; Convertir el ángulo ingresado a radianes
  (let ((radianes (grados-radianes angulo)))
    ;; Imprimir el resultado
    (format t "El ángulo en radianes es: ~A~%" radianes)))

x:5
[+, 5, 5]

(setq x 4)


envirmoent:
variables = map()
variables.add(x: 4)