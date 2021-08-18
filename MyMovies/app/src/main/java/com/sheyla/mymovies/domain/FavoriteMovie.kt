package com.sheyla.mymovies.domain

class FavoriteMovie {
        private var id: Int = 0
        private var title: String = ""

        public fun setId(id: Int){
            this.id = id
        }

        public fun getId(): Int{
            return this.id
        }

        public fun getTitle(): String{
            return this.title
        }

        public fun setTitle(title: String){
            this.title = title
        }
    }
