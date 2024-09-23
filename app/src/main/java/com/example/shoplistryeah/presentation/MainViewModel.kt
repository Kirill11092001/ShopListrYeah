package com.example.shoplistryeah.presentation
import ShopListRepositoryImpl
import androidx.lifecycle.ViewModel
import com.example.shoplistryeah.domain.DeleteShopItemUseCase
import com.example.shoplistryeah.domain.EditShopItemUseCase
import com.example.shoplistryeah.domain.GetShopListUseCase
import com.example.shoplistryeah.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}