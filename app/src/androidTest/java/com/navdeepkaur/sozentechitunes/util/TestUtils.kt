package com.navdeepkaur.sozentechitunes.util


import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher


/**
 * Created by Navdeep Kaur on 11/29/2021
 * navdeep.kaur36026@gmail.com
 */
fun atPosition(position: Int, @NonNull itemMatcher: Matcher<View?>): Matcher<View?> {
    return object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("has item at position $position: ")
            itemMatcher.describeTo(description)
        }

        override fun matchesSafely(view: RecyclerView): Boolean {
            val viewHolder = view.findViewHolderForAdapterPosition(position)
                ?: // has no item on such position
                return false
            return itemMatcher.matches(viewHolder.itemView)
        }
    }
}

fun clickChildWithViewId(id:Int) : ViewAction {
    return object : ViewAction {
         override fun getConstraints(): Matcher<View>? {
                 return null
         }

         override fun getDescription(): String {
             return "click on child with $id"
         }

         override fun perform(uiController: UiController?, view: View?) {
             view?.findViewById<View>(id)?.performClick()
         }

     }
}


