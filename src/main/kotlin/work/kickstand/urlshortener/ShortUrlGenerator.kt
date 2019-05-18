package work.kickstand.urlshortener

import java.lang.StringBuilder
import java.util.*
import kotlin.math.pow

class ShortUrlGenerator {

    companion object {

        fun generateShortUrl() : String {
            return this.longToRandomString(UUID.randomUUID().leastSignificantBits)
        }

        private fun longToRandomString(randomNum: Long) : String {
            var absLong = randomNum.rem(urlValueRange).plus(minUrlValue)

            val shortUrl = StringBuilder()

            while (absLong != 0L) {
                val index = absLong.rem(urlCharSet.size).toInt()
                shortUrl.append(urlCharSet[index])
                absLong /= urlCharSet.size
            }

        return shortUrl.toString()
    }

        private val urlCharSet = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        private val minUrlValue = urlCharSet.size.toDouble().pow(2).toInt()
        private val maxUrlValue = urlCharSet.size.minus(1).times(urlCharSet.size.toDouble().pow(6).toInt())
        private val urlValueRange = maxUrlValue - minUrlValue
    }
}