# Desafio 3

## El objetivo es asimilar los conceptos de clases y objetos, interfaces y clases abstractas.

Una torre de control tiene la responsabilidad de gestionar el aterrizaje de objetos que
sobrevuelan el espacio aéreo.

Para esto, dispone de un sistema que permite que los Voladores sean capaces de aterrizar en la
pista 1.

Pero solamente permite que ciertos Voladores puedan realizar esta acción, por este motivo la
torre tiene un contrato que deben cumplir. Esto permite que no todo objeto aterrice.

Aquellos que son voladores, pero NO cumplan con este contrato, debe pedir autorización
adicional y dependerá de la confirmación de un operario, quien dirá SI o No.

Si el operador acepta podrán aterrizar en la pista 2, de lo contrario se informará que no es posible
aterrizar.

Nota: Para esto desarrollar las clases e interfaces que considere necesario.
-Cargar los objetos en una lista y recorrer cada elemento identificando quien pueden y quienes
no descender.