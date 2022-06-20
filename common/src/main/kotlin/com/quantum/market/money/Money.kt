package com.quantum.market.money

import java.math.BigDecimal
import java.util.*
import java.util.function.Function

class Money internal constructor(val amount: BigDecimal) {

    operator fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    operator fun minus(amount: Money): Money {
        return Money(this.amount.subtract(amount.amount))
    }

    operator fun times(percent: Double): Money {
        return Money(amount.multiply(BigDecimal.valueOf(percent)))
    }

    fun divide(divisor: Double): Money {
        return Money(amount.divide(BigDecimal.valueOf(divisor)))
    }

    fun isLessThan(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }

    fun longValue(): Long {
        return amount.toLong()
    }

    fun doubleValue(): Double {
        return amount.toDouble()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Money) {
            return false
        }
        return amount.toDouble() == other.amount.toDouble()
    }

    override fun hashCode(): Int {
        return Objects.hashCode(amount)
    }

    override fun toString(): String {
        return amount.toString() + "원"
    }

    companion object {
        val ZERO = wons(0)
        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun wons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun <T> sum(bags: Collection<T>, monetary: Function<T, Money>): Money {
            return bags.stream().map { t: T -> monetary.apply(t) }
                .reduce(ZERO) { obj: Money, amount: Money -> obj.plus(amount) }
        }
    }
}