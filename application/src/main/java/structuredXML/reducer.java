package structuredXML;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.StringReader;
import java.io.StringWriter;


import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;



public class reducer extends Reducer<Text, Text, Text, NullWritable> {
    private ArrayList<String> comments = new ArrayList<String>();
    private String companyName ;
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        comments.clear();

        companyName = key.toString();
        // For each input value
        for (Text t : values) {

            if(!t.toString().equals("none") ||!t.toString().equals("None") ) {
                comments.add(t.toString());

            }
        }
        // If there are no comments, the comments list will simply be empty.

        // If post is not null, combine post with its comments.
        String companytWithCommentChildren = null ;
        if (companyName != null) {
            // nest the comments underneath the post element

            try {
                companytWithCommentChildren = nestElements(companyName, comments);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // write out the XML

        }
        context.write(new Text(companytWithCommentChildren),
                NullWritable.get());
    }


    //------NESTElements

    private String nestElements(String post, List<String> comments) throws Exception {
    StringBuilder doc = new StringBuilder();
        doc.append("\n");
        doc.append("\n");
    doc.append("<CompanyName>"+post+"</CompanyName>");

    for(String s : comments){
        doc.append("\n");
        doc.append("<Comment>"+s+"</Comment>");
    }
    return doc.toString();
    }
}

