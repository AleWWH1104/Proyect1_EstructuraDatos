# Lisp Interpreter

Este es un intérprete de Lisp desarrollado en Java que permite ejecutar expresiones en formato Lisp y realizar operaciones como definir funciones, evaluar expresiones aritmeticas y condicionales y trabajar con variables.

## Funcionamiento del Programa

El programa funciona como un intérprete de Lisp, donde se pueden ingresar expresiones en formato Lisp y obtener los resultados de su evaluación. Algunas de las funcionalidades principales son:

- Interpretación de expresiones Lisp.
- Definición y uso de funciones.
- Evaluación de operaciones básicas como suma, resta, multiplicación y división.
- Evaluación de comparadores y condiciones
- Uso de predicados
- Trabajo con variables en el entorno de ejecución.

## Clases Principales

### Environment

La clase `Environment` representa el entorno de evaluación del intérprete. Permite almacenar funciones, variables y proporciona métodos para acceder y modificar el entorno durante la ejecución del programa.

### Evaluador

La clase `Evaluador` se encarga de evaluar las expresiones Lisp. Utiliza un entorno de evaluación (`Environment`) y una factoría (`FactoryEstructuras`) para crear las implementaciones necesarias de las estructuras de datos y realizar las operaciones correspondientes.

### FactoryEstructuras

La clase `FactoryEstructuras` es una factoría que crea instancias de implementaciones de la interfaz `Iestructuras` basándose en la palabra reservada proporcionada. Esto incluye la creación de estructuras como funciones, operadores matemáticos, comparadores, entre otros.

### Parser

La clase `Parser` es responsable de analizar y parsear expresiones Lisp en tokens para su posterior evaluación. Utiliza un objeto StringTokenizer para dividir la expresión en tokens según ciertas reglas de separación, como espacios y paréntesis.

## Java Collectors Utilizados

El programa utiliza Java Collectors en varias partes de su código para trabajar con colecciones de objetos. Algunos de los Java Collectors utilizados son:

- `HashMap`: Utilizado en la clase `Environment` para almacenar funciones y variables.
- `ArrayList`: Utilizado en la clase `Evaluador` para manipular listas de tokens y resultados de evaluación.
- `StringTokenizer`: Utilizado en la clase `Parser` para parsear expresiones Lisp en tokens.

Estas son algunas de las clases principales y Java Collectors utilizados en el proyecto. Para más detalles sobre cada clase y su funcionamiento, se recomienda revisar el código fuente del programa.

## Enlances de consulta
https://www.tutorialspoint.com/lisp/index.htm 
https://www.geeksforgeeks.org/atoms-in-lisp/?ref=ml_lbp

---


