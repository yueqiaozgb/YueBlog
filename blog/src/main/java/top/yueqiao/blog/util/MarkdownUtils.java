package top.yueqiao.blog.util;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.ext.task.list.items.TaskListItemsExtension;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

/**
 * @author yueqiao
 * @date 2025/03/31/17:42
 */
public class MarkdownUtils {

    //为h标签生成id 供tocbot目录生成
    private static final Set<Extension> HEADING_ANCHOR_EXTENSIONS = Collections.singleton(HeadingAnchorExtension.create());
    //转换table的HTML
    private static final List<Extension> TABLE_EXTENSION = List.of(TablesExtension.create());
    //任务列表
    private static final Set<Extension> TASK_LIST_EXTENSION = Collections.singleton(TaskListItemsExtension.create());
    //删除线
    private static final Set<Extension> DEL_EXTENSION = Collections.singleton(StrikethroughExtension.create());

    private static final Parser PARSER = Parser.builder()
            .extensions(HEADING_ANCHOR_EXTENSIONS)
            .extensions(TASK_LIST_EXTENSION)
            .extensions(DEL_EXTENSION)
            .build();

    private static final HtmlRenderer RENDERER = HtmlRenderer.builder()
            .extensions(HEADING_ANCHOR_EXTENSIONS)
            .extensions(TABLE_EXTENSION)
            .extensions(TASK_LIST_EXTENSION)
            .extensions(DEL_EXTENSION)
            .attributeProviderFactory(context -> new CustomAttributeProvider())
            .build();

    /**
     * 自定义标签的属性
     */
    private static class CustomAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            // 为懒加载提供属性
            if (node instanceof Image n) {
                attributes.put("data-src", n.getDestination());
                attributes.remove("src");
            }
            //改变a标签的target属性为_blank
            if (node instanceof Link n) {
                String destination = n.getDestination();
                //判断是否页内锚点跳转
                if (destination.startsWith("#")) {
                    //针对tocbot锚点跳转的class属性
                    attributes.put("class", "toc-link");
                } else {
                    //外部链接
                    attributes.put("target", "_blank");
                    attributes.put("rel", "external nofollow noopener");
                }
            }
            if (node instanceof TableBlock) {
                //针对 semantic-ui 的class属性
                attributes.put("class", "ui celled table");
            }
        }
    }

    /**
     * 增加扩展
     */
    public static String markdownToHtmlExtensions(String markdown) {
        Node document = PARSER.parse(markdown);
        return RENDERER.render(document);
    }

    public static void main(String[] args) {
        System.out.println(markdownToHtmlExtensions("# 1 ## 2 ### 4 1211"));
    }

}
