package com.example.shoplistryeah.data

import com.example.shoplistryeah.domain.ShopItem
import com.example.shoplistryeah.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    private var autoIncrementId = 0

    private val shopList = mutableListOf<ShopItem>()

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Item with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {

        return shopList.toList()
    }
}