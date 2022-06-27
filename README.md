# JavaFX教职工管理系统

本管理系统为大一下学期课程设计作业，因网上关于JavaFX的资料暂且不够丰富（中文方面的资料确实少，一些问题的解决方案没找到，大部分还是从`油管`和`Stackoverflow`上学习的，属实难受😢），学习起来比较麻烦，特此将本课程设计的源码公开，希望能帮助到大家。

------

- ⚠️因时间急促，仅花了一周时间完成该课程设计，存在不足的地方，还请多多包涵。
- ⚠️该项目没有连接`数据库`，没有用`JavaWeb`，大一的课程设计要什么自行车🤪

------

[TOC]

## 介绍

**教职工管理系统** 使用`SceneBuilder`来进行布局， 使用该方法，你可以轻松快速的绘制出页面，而不需要写布局方面的代码。

`SceneBuilder`[使用教程]([javafx scene builder安装和使用教程（java做可视化界面）_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1Bi4y1u775?spm_id_from=333.337.search-card.all.click&vd_source=f5f279ce6eb5aec049d9d0f2e44d09c6))

**教职工管理系统**中一些按钮或者文本框使用了CSS样式，它可以使这些控件变得更加美观（❗JavaFX中的JavaFX CSS 与CSS写法略有不同，你可以在官网文档里查看具体的写法）
`JavaFX CSS`[使用教程]([JavaFX CSS Reference Guide (oracle.com)](https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html))

**教职工管理系统**使用`ArrayList`来对数据进行增删改查，当然你可以使用`LinkedList`或者`Map`等数据结构来完成数据的处理（<u>这取决于你的掌握程度和偏好</u>）

**教职工管理系统**没有使用二进制IO来完成文件的读取和保存（👀如果需要，你可以自己改进文件读写的代码）

****


## 登录界面

[代码](https://help.github.com/articles/github-flavored-markdown/)👈

![image-20220627165120136](C:\Users\Fu-yen Chung\AppData\Roaming\Typora\typora-user-images\image-20220627165120136.png)

## 注册界面

You could find shortcut keys in the right side of menu items from menu bar. For more shortcut key details and custom key bindings, you can refer [here](http://support.typora.io/Shortcut-Keys/).

## 菜单界面

![image-20220627165245816](C:\Users\Fu-yen Chung\AppData\Roaming\Typora\typora-user-images\image-20220627165245816.png)

## 输入信息界面

**Typora** is able to analyze styles of the text content in your clipboard when pasting. For example, after pasting a `<h1>HEADING</h1>` from some website, typora will keep the 'first level heading’ format instead of paste ‘heading’ as plain text. 

To **paste as markdown source** or plain text, you should use `paste as plain text` or press the shortcut key: `shift+cmd+v`.

## 搜索信息界面

Please refer to `Help` → `Custom Themes` from menu bar.

## 修改信息界面

Currently Typora only support to export as **PDF** or **HTML**. More data format support as import/export will be integrated in future.

## 删除信息界面

Typora support  auto save feature, user could enable it from preference panel. 

Typora does not provide professional version control and file backup feature, but typora would backup the last file content from time to time automatically, so even when typora crashes or users forget to save the file before close, it is possible to recovery most of the work by clicking `Recovery Unsaved Drafts` from preference folder, and copy out backed-up files. The File name in this folder is consists of last saved date, originally file name and last saved timestamp.

## 显示信息界面

<https://support.typora.io/>

## 声明

- 本项目的UI部分参考了`微信公众号开放平台`，部分素材来自`即时设计`，`MasterGo`和`IconParkHome`
- 本项目仅供学习和参考，请勿用于商业行为
