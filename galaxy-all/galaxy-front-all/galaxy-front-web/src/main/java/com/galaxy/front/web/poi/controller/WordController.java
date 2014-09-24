package com.galaxy.front.web.poi.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakClear;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*author:huangshanqi
 *time  :2014年9月21日 下午1:22:35
 *email :hsqmobile@gmail.com
 */

@Controller
@RequestMapping(value = "/api/v1")
public class WordController {

	@RequestMapping(value = "/word",method = RequestMethod.GET)
	public void getWord(HttpServletRequest request,HttpServletResponse response){
		
		ServletOutputStream servletOutputStream = null;
		
		
		XWPFDocument doc = new XWPFDocument();

        XWPFParagraph p1 = doc.createParagraph();
        p1.setAlignment(ParagraphAlignment.CENTER);
        p1.setBorderBottom(Borders.DOUBLE);
        p1.setBorderTop(Borders.DOUBLE);

        p1.setBorderRight(Borders.DOUBLE);
        p1.setBorderLeft(Borders.DOUBLE);
        p1.setBorderBetween(Borders.SINGLE);

        p1.setVerticalAlignment(TextAlignment.TOP);

        XWPFRun r1 = p1.createRun();
        r1.setBold(true);
        r1.setText("The quick brown fox");
        r1.setBold(true);
        r1.setFontFamily("Courier");
        r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
        r1.setTextPosition(100);

        XWPFParagraph p2 = doc.createParagraph();
        p2.setAlignment(ParagraphAlignment.RIGHT);

        //BORDERS
        p2.setBorderBottom(Borders.DOUBLE);
        p2.setBorderTop(Borders.DOUBLE);
        p2.setBorderRight(Borders.DOUBLE);
        p2.setBorderLeft(Borders.DOUBLE);
        p2.setBorderBetween(Borders.SINGLE);

        XWPFRun r2 = p2.createRun();
        r2.setText("微软推出了Office兼容性补丁包，通过应用这兼容性补丁包，"
        		+ "WinXP、Win7的用户现在可以打开、编辑、保存Word、Excel和PowerPoint 2007中使用的新格式的文档。此兼容性补丁包也能结合Office Word Viewer 2003，"
        		+ "Excel Viewer 2003和PowerPoint Viewer 2003使用来浏览用新格式保存的文件。有关这个兼容性包更多的信息请查看微软的知识库文章924074。"
                + "docx格式的文件本质上是一个ZIP文件。将一个docx文件的后缀改为ZIP后是可以用解压工具打开或是解压的。事实上，Word2007的基本文件就是ZIP格式的，他可以算作是docx文件的容器。"
                + "docx 格式文件的主要内容是保存为XML格式的，但文件并非直接保存于磁盘。它是保存在一个ZIP文件中，然后取扩展名为docx。将.docx 格式的文件后缀改为ZIP后解压, 可以看到解压出来的文件夹中有word这样一个文件夹，它包含了Word文档的大部分内容。而其中的document.xml文件则包含了文档的主要文本内容");
       
        r2.setFontSize(20);

        XWPFRun r3 = p2.createRun();
        r3.setText("and went away");
        r3.setStrike(true);
        r3.setFontSize(20);
        r3.setSubscript(VerticalAlign.SUPERSCRIPT);


        XWPFParagraph p3 = doc.createParagraph();
        p3.setWordWrap(true);
        p3.setPageBreak(true);
                
        //p3.setAlignment(ParagraphAlignment.DISTRIBUTE);
        p3.setAlignment(ParagraphAlignment.BOTH);
        p3.setSpacingLineRule(LineSpacingRule.EXACT);

        p3.setIndentationFirstLine(600);
        

        XWPFRun r4 = p3.createRun();
        r4.setTextPosition(20);
        r4.setText("To be, or not to be: that is the question: "
                + "Whether 'tis nobler in the mind to suffer "
                + "The slings and arrows of outrageous fortune, "
                + "Or to take arms against a sea of troubles, "
                + "And by opposing end them? To die: to sleep; ");
        r4.addBreak(BreakType.PAGE);
        r4.setText("No more; and by a sleep to say we end "
                + "The heart-ache and the thousand natural shocks "
                + "That flesh is heir to, 'tis a consummation "
                + "Devoutly to be wish'd. To die, to sleep; "
                + "To sleep: perchance to dream: ay, there's the rub; "
                + ".......");
        r4.setItalic(true);
//This would imply that this break shall be treated as a simple line break, and break the line after that word:

        XWPFRun r5 = p3.createRun();
        r5.setTextPosition(-10);
        r5.setText("For in that sleep of death what dreams may come");
        r5.addCarriageReturn();
        r5.setText("When we have shuffled off this mortal coil,"
                + "Must give us pause: there's the respect"
                + "That makes calamity of so long life;");
        r5.addBreak();
        r5.setText("For who would bear the whips and scorns of time,"
                + "The oppressor's wrong, the proud man's contumely,");
        
        r5.addBreak(BreakClear.ALL);
        r5.setText("The pangs of despised love, the law's delay,"
                + "The insolence of office and the spurns" + ".......");
		
        try {
        	response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        	response.setHeader("Content-Disposition", "attachment; filename="+"测试");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "max-age=0");
            
			servletOutputStream = response.getOutputStream();
			
			doc.write(servletOutputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (servletOutputStream!= null) {
				try {
					servletOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        
		
	}
}
