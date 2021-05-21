package curso_collections_listas_array

import java.math.BigDecimal

fun Array<BigDecimal>.media() : BigDecimal {
    return if(this.isEmpty()){
        BigDecimal.ZERO
    } else {
       this.reduce{
           acc, valor -> acc + valor
       } / this.size.toBigDecimal()
    }
}

fun List<BigDecimal>.average(): BigDecimal {
    return if(this.isEmpty()) {
        BigDecimal.ZERO
    } else {
        this.reduce{acc, valor -> acc + valor}/this.size.toBigDecimal()
    }
}