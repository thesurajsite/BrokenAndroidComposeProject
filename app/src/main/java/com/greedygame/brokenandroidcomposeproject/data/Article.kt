package com.greedygame.brokenandroidcomposeproject.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


data class Article(
    @SerializedName("identifier")
    val id: Int,
    @SerializedName("heading")
    val title: String,
    @SerializedName("writer")
    val author: String?,
    val content: String?,
    val imageUrl: String?
)

object BrokenRepository {
    fun fetchArticlesBlocking(): List<Article> {
        Thread.sleep(2000)
        val fakeJson = "[{\"identifier\":1,\"heading\":\"News 1\",\"writer\":\"Alice\",\"content\":\"This is a demo news content by Alice\",\"imageUrl\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%2Fid%2FOIP.m45EGH2G9pcjIYKUfY7HmwHaHa%3Fpid%3DApi&f=1&ipt=eb5f0e7746bd1c644bb6e4e2c2886f74fdcb3db5a07afc19337c0cc89218e646&ipo=images\"},{\"identifier\":2,\"heading\":\"News 2\",\"writer\":\"Justin\",\"content\":\"This is a demo news content by Justin\",\"imageUrl\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%2Fid%2FOIP.2Yl82xphvP0N_GO982HQlAHaE8%3Fpid%3DApi&f=1&ipt=3bd6af37201c1976f266eb4dec707864364230c75cb845f47161fa7e151321e4&ipo=images\"},{\"identifier\":3,\"heading\":\"News 3\",\"writer\":\"Surbhi\",\"content\":\"This is a demo news content by Surbhi\",\"imageUrl\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%2Fid%2FOIP.0T8y1MQrRei4pJAWeeaFwgHaFP%3Fpid%3DApi&f=1&ipt=38721c132c6b8c01eecd110450d26cd3e34e5788518224259a7b23bf6183399e&ipo=images\"},{\"identifier\":4,\"heading\":\"News 4\",\"writer\":\"suraj\",\"content\":\"This is a demo news content by Suraj\",\"imageUrl\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%2Fid%2FOIP.HgeQdwOlARdKVbNkSIwi1AHaEO%3Fpid%3DApi&f=1&ipt=ac8d89a634189e0d9c1fa63bf69c7b1d7bbe5ea5dd49c7615eb65e5b18c9e124&ipo=images\"},{\"identifier\":5,\"heading\":\"News 5\",\"writer\":\"Priti\",\"content\":\"This is a demo news content by Priti\",\"imageUrl\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%2Fid%2FOIP.yBb4xvDQoK7hVjy8KwcNKwHaFO%3Fpid%3DApi&f=1&ipt=7665191660194f9350ade4aa87b36827bfbdb987811e17238ed2880f15ac9a69&ipo=images\"}]"
        val gson = Gson()
        val articles: Array<Article> = try {
            gson.fromJson(fakeJson, Array<Article>::class.java)
        } catch (e: Exception) {
            emptyArray()
        }
        return articles.toList()
    }

    fun updateArticle(article: Article) {
    }
}