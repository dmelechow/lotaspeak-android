package com.lotaspeak.speak.di.threads

import com.lotaspeak.speak.di.app.AppComponent
import com.lotaspeak.speak.di.scopes.ThreadsScope
import com.lotaspeak.speak.view.threads.ThreadsFragment
import dagger.Component


@ThreadsScope
@Component(modules = [(ThreadsModule::class)], dependencies = [(AppComponent::class)])
interface ThreadsComponent {
    fun inject(fragment: ThreadsFragment)
}