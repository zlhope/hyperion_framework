from bs4 import BeautifulSoup
 
class HtmlHandler:
    def __init__(self,path,data=[],scope="BAT"):
        self.data=data
        self.path=path
        self.scope=scope
    
    def excute(self):
        for info in self.data:
            if self.scope=="TEST":
                html_file=self.path+"\com.telenav.uia.android.denali.testcase."+info["testclass"]+".html"
            else:
                html_file=self.path+"\com.telenav.uia.android.denali.testcase."+info["testclass"]+".html"
            fobj = open(html_file)
            data = fobj.read()
            fobj.close()
            soup = BeautifulSoup(data, "html.parser")
            h3list = soup.findAll("h3")
            for h3 in h3list:
                if h3.string==info["testname"]:
                    tag = soup.new_tag("img")
                    tag.attrs={"src":"img/"+info["failinfo"],"width":"50%","height":"50%"}
                    h3.find_next("pre").append(tag)
                    fobj = file(html_file, "w");
                    fobj.write(str(soup));
                    fobj.close();
                    
    def setCarrier(self,carrier):
        html_file=self.path+"\index.html"
        fobj = open(html_file)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        h1 = soup.find("h1")
        h1.insert(0,carrier.upper()+" ")
        import time
        h1.append(" at "+time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
        fobj = file(html_file, "w");
        fobj.write(str(soup));
        fobj.close();
        print "Set carrier info on the index.html successfully!"
    
    def correct_anchor(self):
         html_file=self.path+"\index.html"
         fobj = open(html_file)
         data = fobj.read()
         fobj.close()
         soup = BeautifulSoup(data, "html.parser")
         table=soup.findAll("table")
         tds = table[2].findAll("td",{"class":"failures"})
         for td in tds:
             tag=td.findChild()
             tag["href"]=tag.attrs["href"].replace("#s","#"+tag.text)
         tab2 = soup.find("div",{"id":"tab2"})
         tbody=tab2.find_next("tbody")
         trs=tbody.findAll("tr")
         for item in trs:
             link_td=item.findAll("td")[0]
             link=item.find("a")
             link_td.append(link)
         fobj = file(html_file, "w");
         fobj.write(str(soup));
         fobj.close();
         print "Correct the anchor on the index.html successfully!"
    
    def excute_staisic(self,case_info):
        fobj = open(self.path)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        tr = soup.find("tr")
        tag0 = soup.new_tag("tr")
        tag1 = soup.new_tag("td")
        tag2 = soup.new_tag("td")
        tag3 = soup.new_tag("td")
        tag4 = soup.new_tag("td")
        fail_list=case_info["failinfo"]
        tag1.attrs={"rowspan":len(fail_list)}
        tag2.attrs={"rowspan":len(fail_list)}
        tag3.attrs={"rowspan":len(fail_list)}
        tag4.attrs={"rowspan":len(fail_list)}
        tag1.insert(0, str(case_info["id"]))
        tag2.insert(0, case_info["testname"])
        tag3.insert(0, str(case_info["failures"]))
        tag4.insert(0, case_info["percentage"])
        tag0.append(tag1)
        tag0.append(tag2)
        tag0.append(tag3)
        tag0.append(tag4)
        for i in range(len(fail_list)):
            if i==0:
                tag5 = soup.new_tag("td")
                tag6 = soup.new_tag("td")
                tag5.insert(0, fail_list[0]["detail"])
                tag6.insert(0, str(fail_list[0]["count"]))
                tag0.append(tag5)
                tag0.append(tag6)
            else:
                tmptag=soup.new_tag("tr")
                tmptag_1 = soup.new_tag("td")
                tmptag_2 = soup.new_tag("td")
                tmptag_1.insert(0, fail_list[i]["detail"])
                tmptag_2.insert(0, str(fail_list[i]["count"]))
                tmptag.append(tmptag_1)
                tmptag.append(tmptag_2)
                tag0.append(tmptag)   
        tr.append(tag0)
        fobj = file(self.path, "w");
        fobj.write(str(soup));
        fobj.close();
    
    def insert_tag(self,tag_name,tag,pos=True):
        fobj = open(self.path)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        if pos:
            t_tag = soup.find(tag_name)
            t_tag.append(tag)
        else:
            t_tags = soup.findAll(tag_name)
            t_tags[-1].insert_before(tag)
        fobj = file(self.path, "w");
        fobj.write(str(soup));
        fobj.close();
    
    def get_tags(self,tag_name,attr={}):
        fobj = open(self.path)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        tags = soup.findAll(tag_name,attr)
        return tags
    
    def set_backlog_link(self):
        fobj = open(self.path)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        tag = soup.find("div",{"id":"tabs"})
        title1=soup.new_tag("h1")
        title1.append("Failures Backlog History Link")
        title2=soup.new_tag("h1")
        title2.append("Execution History Chart")
        title3=soup.new_tag("h1")
        title3.append("Output Log Link")
        link=soup.new_tag("a")
        link.attrs={"href":"backlog.html","target":"_blank"}
        link.append("Failures Backlog History")
        link1=soup.new_tag("a")
        link1.attrs={"href":"output.html","target":"_blank"}
        link1.append("Output Log")
        tag.insert_after(soup.new_tag("br"))
        tag.insert_after(title2)
        tag.insert_after(soup.new_tag("br"))
        tag.insert_after(soup.new_tag("br"))
        tag.insert_after(link)
        tag.insert_after(soup.new_tag("br"))
        tag.insert_after(title1)
        tag.insert_after(soup.new_tag("br"))
        tag.insert_after(link1)
        tag.insert_after(soup.new_tag("br"))
        tag.insert_after(title3)
        tag.insert_after(soup.new_tag("br"))
        fobj = file(self.path, "w");
        fobj.write(str(soup));
        fobj.close();
    
    def generate_output(self):
        fobj = open(self.path)
        data = fobj.read()
        fobj.close()
        fobj = open(r"..\app\build\log\Android_Automation_Log.log")
        data1 = fobj.readlines()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        tag = soup.find("pre")
        i=0
        while (i <len(data1)):
            if data1[i].find("[StackTrace Start]")!=-1:
                temp_list=[]
                while(i<len(data1)):
                    temp_list.append(data1[i])
                    i=i+1
                    if data1[i-1].find("[StackTrace End]")!=-1:
                        tag.append(self.create_toggle_tag(temp_list,soup,i))
                        break
            if i<len(data1):
                tag.append(data1[i])
            i=i+1
        fobj = file(self.path, "w");
        fobj.write(str(soup));
        fobj.close();
    
    def create_toggle_tag(self,data,soup,index):
        root_tag=soup.new_tag("div")
        root_tag.attrs={"class":"element-header","onclick":"myclick("+str(index)+")"}
        tag1=soup.new_tag("div")
        tag1.attrs={"class":"element-header-left"}
        tag1.append(data[0])
        tag2=soup.new_tag("div")
        tag2.attrs={"class":"element-header-toggle-close","id":"moredetail"+str(index)}
        tag3=soup.new_tag("div")
        tag3.attrs={"style":"display:none;","id":"detail"+str(index)}
        tag4=soup.new_tag("pre")
        tag4.attrs={"style":"color:red;"}
        for i in range(len(data)):
            if i>1:
                tag4.append(data[i])
        tag3.append(tag4)
        root_tag.append(tag1)
        root_tag.append(tag2)
        root_tag.append(tag3)
        return root_tag
                       
if __name__ == '__main__' :
    import os
    os.system(r"copy ..\..\app\build\reports\androidTests\connected\index_bk.html ..\..\app\build\reports\androidTests\connected\index.html /y")
    folder_name=r'..\..\app\build\reports\androidTests\connected'
    handle=HtmlHandler(folder_name)
    handle.correct_anchor()
    #handle.output_add_toggle()
    #handle.excute_staisic(data2)
    