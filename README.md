# Prototype Trip

> 실제 프로젝트에 적용하기 전에 필요한 기술등을 테스트 하는 목적의 안드로이드 프로젝트입니다.



#### 제한사항

> 민감정보와 상관없는 Guest API만을 사용합니다.



#### 구성 및 의존성

* Android
  * Min API 21
* Kotlin
  * Corountine
* 패턴
  * MVVM
* AndroidX
* JetPack
  * ViewModel
  * DataBinding
  * LiveData
  * Room
  * Navigation
* Network
  * Retrofit2
  * Moshi
* Image
  * Glide
* DI
  * Dagger2
  * Dagger-Android
* Material
  * Theme
  * Style
* Timber (Logging)



#### 구조 (Clean Architecture / MVVM)

* App Module
  * Presentation Layer
* Shared Module
  * Data / Domain(Interactor) Layer
* Model Module
  * Model Layer
* Test Support Module (Mock을 사용하지 않은 테스트를 위한 모듈)
  * AndroidTest-Shared Module
  * Test-Shared Module

​	