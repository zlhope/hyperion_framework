from xml.dom import minidom , Node
import os,re
 
class XmlParser:
    def __init__(self,path):
        self.data=[]
        self.path=path
        self.case=None
        
    def handle_doc(self,doc):
        for child in doc.childNodes :
            if child.nodeType == Node.ELEMENT_NODE \
            and child.tagName == "testcase" :
                testname = child.getAttribute("name")
                testclass = child.getAttribute("classname")
                failinfo= self.handle_failinfo(child)
                if failinfo!="" and failinfo is not None:
                    tmp={"testname":testname,
                         "testclass":testclass,
                         "failinfo":failinfo}
                    self.data.append(tmp)
                
    def handle_failinfo(self,node):
        for child in node.childNodes :
            if child.nodeType == Node.ELEMENT_NODE :
                if child.tagName == "failure":
                    return self.get_text(child.firstChild)
             
    def get_text(self,node):
        if node.nodeType == Node.TEXT_NODE :
            for line in node.nodeValue.split("\n"):
                if line.find("IMG_CMP_CASE")!= -1:
                    return "IMG_CMP_CASE"
                else:
                    r = re.search('\d{14}_(.*\.png)', line)
                    if r is not None:
                        return r.group()
        else: return ""
    
    def get_xml_info(self):
        file_list = os.listdir(self.path)
        doc = minidom.parse(self.path+"\\"+file_list[0])
        for child in doc.childNodes :
            if child.nodeType == Node.ELEMENT_NODE:
                self.handle_doc(child)
        return self.data
                
    def get_statistic_info(self):
        file_list = os.listdir(self.path)
        for file_name in file_list:
            if file_name.find(r".xml") != -1:
                xml_file = file_name
                break
        doc = minidom.parse(self.path+"\\" + xml_file)
        for child in doc.childNodes :
            if child.nodeType == Node.ELEMENT_NODE:
                self.handle_statistic(child)
    
    def handle_statistic(self,doc):
        for child in doc.childNodes :
            if child.nodeType == Node.ELEMENT_NODE \
            and child.tagName == "testcase" :
                self.case = child.getAttribute("name")
                failinfo= self.handle_statistic_failure(child)
                if failinfo!="" and failinfo is not None:
                    tmp={"testname":self.case,
                         "failinfo":failinfo}
                    self.data.append(tmp)
    
    def handle_statistic_failure(self,node):
        for child in node.childNodes :
            if child.nodeType == Node.ELEMENT_NODE :
                if child.tagName == "failure":
                    return self.get_statistic_text(child.firstChild)
    
    def get_statistic_text(self,node):
        if node.nodeType == Node.TEXT_NODE :
            line_list=node.nodeValue.split("\n")
            for i in range(len(line_list)):
                if i==0:
                    r = re.search(" ?\d{14}_", line_list[i])
                    if r is not None:
                        line_list[i]=line_list[i].replace(r.group(),"")
                    ret=line_list[i].replace(".png","")
                else:
                    tmp=line_list[i].split("(")[0].split(".")[-1]
                    ret=ret+"."+tmp
                    if self.case==tmp or i>5:
                        break
            return ret
        else: return ""
     
if __name__ == '__main__' :
    pass
    