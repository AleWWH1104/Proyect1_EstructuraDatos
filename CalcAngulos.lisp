;; Función para convertir grados a radianes
(defun grados-radianes (grados)
  (* grados (/ pi 180)))

;; Ingresar un ángulo en grados
(format t "Ingrese un ángulo en grados: ")
(finish-output)
(let ((angulo (read)))
  ;; Convertir el ángulo ingresado a radianes
  (let ((radianes (grados-radianes angulo)))
    ;; Imprimir el resultado
    (format t "El ángulo en radianes es: ~A~%" radianes)))


