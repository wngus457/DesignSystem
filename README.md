# Android Design System

Jetpack Compose 기반의 Android UI 컴포넌트 라이브러리입니다.

## Installation

### GitHub Packages 설정

`settings.gradle.kts`에 repository 추가:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/wngus457/DesignSystem")
            credentials {
                username = "YOUR_GITHUB_USERNAME"
                password = "YOUR_GITHUB_TOKEN"
            }
        }
    }
}
```

### Dependencies

```kotlin
dependencies {
    implementation("com.juhyeon.androidds:ui:1.0.0")
    implementation("com.juhyeon.androidds:extension:1.0.1")
}
```

## Modules

### UI Module

재사용 가능한 Compose UI 컴포넌트를 제공합니다.

#### Components

| Component | Description |
|-----------|-------------|
| `BasicButton` | Solid, Outlined 스타일 지원 버튼 |
| `BasicFloatingButton` | 플로팅 액션 버튼 |
| `BasicTextButton` | 텍스트 버튼 |
| `BasicIconButton` | 아이콘 버튼 |
| `BasicInputField` | 텍스트 입력 필드 |
| `BasicCheckBox` | 체크박스 |
| `BasicRadioButton` | 라디오 버튼 |
| `BasicStepper` | 숫자 증감 스테퍼 |
| `BasicIcon` | 아이콘 컴포넌트 |
| `BasicTooltip` | 툴팁 |
| `BasicModal` | 모달 다이얼로그 |
| `BasicDivider` | 구분선 |

#### Theme

Light/Dark 테마를 지원합니다.

```kotlin
BasicTheme(themeType = ThemeType.BasicLight) {
    // Your content
}
```

#### Usage Example

```kotlin
// Button
BasicButton(
    type = ButtonStyle.Solid,
    buttonSize = ButtonSize.Medium,
    text = "Click me",
    onClick = { }
)

// Button with Icon
BasicButton(
    type = ButtonStyle.Outlined,
    buttonSize = ButtonSize.Large,
    buttonIcon = ButtonIcon.True(icon = BasicIcons.ArrowRightLarge),
    text = "Next",
    onClick = { }
)

// Disabled Button
BasicButton(
    type = ButtonStyle.Solid,
    state = ButtonState.Disabled,
    text = "Disabled",
    onClick = { }
)
```

### Extension Module

Compose 개발에 유용한 확장 함수를 제공합니다.

| Extension | Description |
|-----------|-------------|
| `ModifierExt` | clickableSingle, clickableIgnoreInteraction 등 |
| `DimentionExt` | 크기 관련 확장 함수 |
| `LazyStateExt` | LazyList 상태 확장 함수 |
| `ScrollStateExt` | 스크롤 상태 확장 함수 |
| `NavigationExt` | Navigation 관련 확장 함수 |

## Requirements

- Min SDK: 26
- Compile SDK: 35
- Java 17
- Kotlin

## License

MIT License