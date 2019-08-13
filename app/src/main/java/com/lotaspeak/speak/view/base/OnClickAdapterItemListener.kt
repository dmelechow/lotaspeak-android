package com.lotaspeak.speak.view.base

import android.view.View

interface OnClickAdapterItemListener: View.OnClickListener {
    fun setListener(externalListener: View.OnClickListener)
}