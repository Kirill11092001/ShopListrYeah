package com.example.shoplistryeah.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {

        shopListRepository.editShopItem(shopItem)
    }
}