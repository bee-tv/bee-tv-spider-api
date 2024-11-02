package com.github.beetv.spider

interface Spider {
    suspend fun fetchCategories(): List<Category>
    suspend fun fetchCategoryMedias(): List<CategoryMedia>
    suspend fun fetchMediaDetail(mediaId: String): MediaDetail
    suspend fun fetchMediaUrl(sourceId: String): String
}

data class Category(
    val id: String,
    val name: String,
) {
    companion object {
        val EMPTY = Category("", "")
    }
}

data class Media(
    val id: String,
    val name: String,
    val cover: String,
    val desc: String,
)

data class MediaDetail(
    val id: String,
    val name: String,
    val cover: String,
    val summary: String,
    val category: Category = Category.EMPTY,
    val sourceGroups: List<SourceGroup>,
    val profiles: Map<String, String> = emptyMap(),
)

data class CategoryMedia(
    val category: Category,
    val medias: List<Media>
)

data class SourceGroup(val name: String, val sources: List<Source>)

data class Source(
    val id: String,
    val name: String,
    val url: String?,
)

data class Page<out T>(
    val items: List<T>,
    val total: Long,
)