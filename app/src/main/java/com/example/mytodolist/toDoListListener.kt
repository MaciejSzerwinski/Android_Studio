package com.example.mytodolist

interface toDoListListener {
    fun onItemClick(position: Int)
    fun onItemLongClick(position: Int)
}