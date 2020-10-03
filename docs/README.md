# Stylar for Android

## Intro
An Android markdown library - it does not require WebView

## Getting Started
For information on how to get started with Stylar,
take a look at our [Getting Started](docs/getting-started.md) guide.

## Submitting Bugs or Feature Requests
Bugs or feature requests should be submitted at our [GitHub Issues section](https://github.com/zeoflow/stylar/issues).

## How does it work?
### 1. Depend on our library

Stylar for Android is available through Google's Maven Repository.
To use it:

1.  Open the `build.gradle` file for your application.
2.  Make sure that the `repositories` section includes Google's Maven Repository
    `google()`. For example:

    ```groovy
      allprojects {
        repositories {
          google()
          jcenter()
        }
      }
    ```

3.  Add the library to the `dependencies` section:

    ```groovy
      dependencies {
        // ...
        implementation 'com.zeoflow:stylar:<version>'
        // ...
      }
    ```

### 2. Add the StylarView component to your app
`activity_main.xml`

```xml
    <!--
        ...
    -->
    <com.zeoflow.stylar.view.StylarView
        android:id="@+id/zStylarView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
    <!--
        ...
    -->
```

### 3. Activity/Fragment Class
`MainActivity.java`

```java
public class MainActivity extends BindAppActivity<ActivityMainBinding, MainViewBinding>
{
    //..
    private StylarView zStylarView;
    //..
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        //..
        zStylarView = findViewById(R.id.zStylarView)
        //..
        final Stylar stylar = Stylar.builder(this)
            .withLayoutElement(zStylarView)
            .withAnchoredHeadings(true)
            .withImagePlugins(true)
            .withCodeStyle(false)
            .setClickEvent(link -> Toast.makeText(MainActivity.this, link, Toast.LENGTH_SHORT).show())
            .usePlugin(new AbstractStylarPlugin() {
                @Override
                public void configureTheme(@NonNull StylarTheme.Builder builder) {
                    builder
                        .codeTextColor(Color.parseColor("#CE570CC1"))
                        .codeBackgroundColor(Color.parseColor("#EDEDED"));
                }
            })
            .build();
        //..
        String mdText = "**[test](#test)**";
        stylar.setMarkdown(mdText);
        //..
    }
    //..
}
```

## License
    Copyright 2020 ZeoFlow
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
      http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.