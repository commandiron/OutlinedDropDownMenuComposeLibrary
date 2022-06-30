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

# Supported attributes

Most of the attributes of that a default `Text` composable has are also supported by `MarkdownText`. 

- color 
- fontSize
- textAlign
- maxLines
- style (only styling for supported attributes is applied)

The font can be changed by passing a font xml resource as `fontResource` parameter. 

## How to use
```kotlin  
val markdown = """  
	# Sample  
	* Markdown  
	* [Link](https://example.com)  
	![Image](https://example.com/img.png)  
	<a href="https://www.google.com/">Google</a>  
"""

//Minimal example
@Composable  
fun MinimalExampleContent() {  
    MarkdownText(markdown = markdownContent)  
} 

//Complex example
@Composable  
fun ComplexExampleContent() {  
     MarkdownText(
                modifier = Modifier.padding(8.dp),
                markdown = markdown,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = LocalContentColor.current,
                maxLines = 3,
                fontResource = R.font.montserrat_medium,
                style = MaterialTheme.typography.overline,
              
     )  
}  
```  
