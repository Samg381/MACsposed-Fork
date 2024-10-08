package com.samg381.macsposedfork

import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class QuickTile: TileService() {
    override fun onStartListening() {
        super.onStartListening()
        PrefManager.loadPrefs(applicationContext)
        setButtonState()
    }

    override fun onClick() {
        super.onClick()
        PrefManager.toggleHookState()
        setButtonState()
    }

    private fun setButtonState() {
        if (PrefManager.isHookOn())
            qsTile.state = Tile.STATE_ACTIVE
        else
            qsTile.state = Tile.STATE_INACTIVE
        qsTile.updateTile()
    }
}