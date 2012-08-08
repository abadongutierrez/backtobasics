
// Implementacion de listas usando Arreglos

// utilizamos una clase para representar una 'estructura de datos'
class Lista {
    Integer ultimo = 0
    Integer[] elementos = new Integer[10]
}

lista = new Lista()

def fin(Lista lista) {
    return lista.ultimo + 1
}

def inserta(Integer x, Integer posicion, Lista lista) {
    if (lista.ultimo >= 10) {
        throw new Exception("La lista esta llena")
    }
    else if (posicion > fin(lista) || posicion < 1) {
        throw new Exception("Posicion ${posicion} no existe en la lista.")
    }
    else { 
        for (int i = lista.ultimo; i >= posicion; --i) {
            lista.elementos[(i - 1) + 1] = lista.elementos[i - 1]
        }
        lista.ultimo = lista.ultimo + 1
        lista.elementos[posicion - 1] = x
    }
}

def imprimeLista(Lista l) {
    def str = "["
    boolean coma = false
    for (int i = 0; i < l.ultimo; i++) {
        if (coma) {
            str += ","
        }
        str += "${l.elementos[i]}"
        coma = true
    }
    str += "]"
}

println "La lista esta vacia, entonces imprimeLista(lista) = ${imprimeLista(lista)} y fin(lista) = ${fin(lista)}"
inserta(5, 1, lista)
println "Despues de insertar un elemento '5' en la posicion '5' en la lista: ${imprimeLista(lista)}"
inserta(4, 2, lista)
inserta(3, 3, lista)
println "${imprimeLista(lista)}, ultimo: ${lista.ultimo}"
inserta(1, 2, lista)
println "inserta(1, 2, lista): ${imprimeLista(lista)}, ultimo: ${lista.ultimo}"