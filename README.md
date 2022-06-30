# Outlined Drop Down Menu - Jetpack Compose

## Setup
1. Open the file `settings.gradle` (it looks like that)
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // add jitpack here 👇🏽
        maven { url 'https://jitpack.io' }
       ...
    }
} 
...
```
2. Sync the project
3. Add dependency
```groovy
dependencies {
        implementation 'com.github.commandiron:outlined-drop-down-menu-compose:1.0'
}
```

## Usage
```kotlin  
val items by remember { mutableStateOf(listOf("item 1", "item 2", "item 3")) }

OutlinedDropDownMenu(
    label = "label",
    items = items,
    unit = " unit",
    onSelect = {
        //SelectedItem
    }
)
```

## View
