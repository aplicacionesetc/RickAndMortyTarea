package dam.pmdm.rickandmortytarea

import android.content.Context

object SeenPrefs {
    private const val PREFS_NAME = "prefs_seen"
    private const val KEY_SEEN_SET = "seen_set"

    fun getSeenSet(context: Context): MutableSet<String> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getStringSet(KEY_SEEN_SET, emptySet())?.toMutableSet() ?: mutableSetOf()
    }

    fun saveSeenSet(context: Context, set: Set<String>) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putStringSet(KEY_SEEN_SET, set).apply()
    }

    fun isSeen(context: Context, episodeId: Int): Boolean {
        return getSeenSet(context).contains(episodeId.toString())
    }

    fun setSeen(context: Context, episodeId: Int, seen: Boolean) {
        val set = getSeenSet(context)
        val key = episodeId.toString()
        if (seen) set.add(key) else set.remove(key)
        saveSeenSet(context, set)
    }
}