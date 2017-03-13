from bs4 import BeautifulSoup
import os
 
class HtmlHandler:
    def __init__(self, path, data=[]):
        self.data = data
        self.path = path
    
    def insert_screen_shot(self):
        gif_files = self.get_gif_file_name()
        for info in self.data:
            for file_name in os.listdir(self.path):
                if file_name.find(r".html") != -1:
                    if file_name.find(info['testclass'])!= -1:
                        html_file = self.path + r"\\" + file_name
                        break
            fobj = open(html_file)
            data = fobj.read()
            fobj.close()
            soup = BeautifulSoup(data, "html.parser")
            h3list = soup.findAll("h3")
            for h3 in h3list:
                if h3.string == info["testname"]:
                    if info["failinfo"] == "IMG_CMP_CASE":
                        imgs = self._get_img_cmp_output_list(info["testname"])
                        if len(imgs) > 0:
                            h3.find_next("pre").string = ""
                            h3.find_next("pre").append(self._create_img_cmp_tag(soup, imgs, info["testname"]))
                    else:
                        tag = soup.new_tag("img")
                        tag.attrs = {"src":"img/" + info["failinfo"], "width":"50%", "height":"50%"}
                        if info["testname"] + '.gif' in gif_files:
                            tag = self.create_gif_tag(soup, tag, info["testname"])
                        h3.find_next("pre").append(tag)
                    fobj = file(html_file, "w");
                    fobj.write(str(soup));
                    fobj.close();
    
    def _get_img_cmp_output_list(self, testname):
        case_id = testname.split("_")[1]
        imgs = []
        for file_name in os.listdir(self.path +r"\img"):
            try:
                tmp = file_name.split("_")[1]
                if tmp == case_id:
                    imgs.append(file_name)
            except:
                pass
        imgs.sort()
        return imgs
                    
    def _create_img_cmp_tag(self, soup , imgs , testname):
        table_tag = soup.new_tag("table")
        table_tag.attrs = {"border":"1"}
        th1_tag = soup.new_tag("th")
        th1_tag.attrs = {"style": "text-align:center; padding-left: 0", "width":"45%"}
        th1_tag.insert(0, "Screen Shooting")
        th2_tag = soup.new_tag("th")
        th2_tag.attrs = {"style": "text-align:center; padding-left: 0", "width":"45%"}
        th2_tag.insert(0, "Screen Reference")
        th3_tag = soup.new_tag("th")
        th3_tag.attrs = {"style": "text-align:center; padding-left: 0", "width":"10%"}
        th3_tag.insert(0, "Similarity")
        tr1_tag = soup.new_tag("tr")
        tr1_tag.append(th1_tag)
        tr1_tag.append(th2_tag)
        tr1_tag.append(th3_tag)
        table_tag.append(tr1_tag)
        for img in imgs:
            td1_tag = soup.new_tag("td")
            td1_tag.attrs = {"style": "text-align:center; padding-left: 0", "width":"45%"}
            td2_tag = soup.new_tag("td")
            td2_tag.attrs = {"style": "text-align:center; padding-left: 0", "width":"45%"}
            td3_tag = soup.new_tag("td")
            td3_tag.attrs = {"style": "text-align:center; padding-left: 0", "width":"10%"}
            img_tag = soup.new_tag("img")
            img_tag.attrs = {"src":"img/" + img, "width":"360px"}
            atag = soup.new_tag("a")
            atag.insert(0, img)
            td1_tag.append(img_tag)
            td1_tag.append(soup.new_tag("br"))
            td1_tag.append(atag)
            td2_tag.insert(0, "TODO")
            td3_tag.insert(0, "TODO")
            tmp_tr_tag = soup.new_tag("tr")
            tmp_tr_tag.append(td1_tag)
            tmp_tr_tag.append(td2_tag)
            tmp_tr_tag.append(td3_tag)
            table_tag.append(tmp_tr_tag)
        return table_tag
    
    def create_gif_tag(self, soup , img_tag , testname):
        table_tag = soup.new_tag("table")
        table_tag.attrs = {"border":"1"}
        th1_tag = soup.new_tag("th")
        h1_tag = soup.new_tag("h2")
        h1_tag.insert(0, "Screen Shooting")
        h2_tag = soup.new_tag("h2")
        h2_tag.insert(0, "Screen Recording")
        th1_tag.append(h1_tag)
        th2_tag = soup.new_tag("th")
        th2_tag.append(h2_tag)
        tr1_tag = soup.new_tag("tr")
        tr1_tag.append(th1_tag)
        tr1_tag.append(th2_tag)
        td1_tag = soup.new_tag("td")
        td1_tag.attrs = {"width":"60%"}
        td1_tag.append(img_tag)
        gif_tag = soup.new_tag("img")
        gif_tag.attrs = {"src":"gif/" + testname + ".gif"}
        td2_tag = soup.new_tag("td")
        td2_tag.attrs = {"width":"40%"}
        td2_tag.append(gif_tag)
        tr2_tag = soup.new_tag("tr")
        tr2_tag.append(td1_tag)
        tr2_tag.append(td2_tag)
        table_tag.append(tr1_tag)
        table_tag.append(tr2_tag)
        return table_tag
    
    def get_gif_file_name(self):
        gif_path = self.path + "\gif"
        if os.path.exists(gif_path):
            file_list = os.listdir(gif_path)
            if file_list == None:
                return []
            else:
                return file_list
        else:
            return []
    
    def set_title(self, title):
        html_file = self.path + "\index.html"
        fobj = open(html_file)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        h1 = soup.find("h1")
        h1.insert(0, title + " ")
        import time
        h1.append(" at " + time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time())))
        fobj = file(html_file, "w");
        fobj.write(str(soup));
        fobj.close();
        print "Set title info on the index.html successfully!"
    
    def correct_anchor(self):
        html_file = self.path + "\index.html"
        fobj = open(html_file)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        table = soup.findAll("table")
        tds = table[2].findAll("td", {"class":"failures"})
        for td in tds:
            tag = td.findChild()
            tag["href"] = tag.attrs["href"].replace("#s", "#" + tag.text)
        tab2 = soup.find("div", {"id":"tab2"})
        if tab2 != None:
            tbody = tab2.find_next("tbody")
            trs = tbody.findAll("tr")
            for item in trs:
                link_td = item.findAll("td")[0]
                link = item.find("a")
                link_td.append(link)
            fobj = file(html_file, "w");
            fobj.write(str(soup));
            fobj.close();
        print "Correct the anchor on the index.html successfully!"
    
    def excute_staisic(self, case_info):
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
        fail_list = case_info["failinfo"]
        tag1.attrs = {"rowspan":len(fail_list)}
        tag2.attrs = {"rowspan":len(fail_list)}
        tag3.attrs = {"rowspan":len(fail_list)}
        tag4.attrs = {"rowspan":len(fail_list)}
        tag1.insert(0, str(case_info["id"]))
        tag2.insert(0, case_info["testname"])
        tag3.insert(0, str(case_info["failures"]))
        tag4.insert(0, case_info["percentage"])
        tag0.append(tag1)
        tag0.append(tag2)
        tag0.append(tag3)
        tag0.append(tag4)
        for i in range(len(fail_list)):
            if i == 0:
                tag5 = soup.new_tag("td")
                tag6 = soup.new_tag("td")
                tag5.insert(0, fail_list[0]["detail"])
                tag6.insert(0, str(fail_list[0]["count"]))
                tag0.append(tag5)
                tag0.append(tag6)
            else:
                tmptag = soup.new_tag("tr")
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
    
    def insert_tag(self, tag_name, tag, pos=True):
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
    
    def get_tags(self, tag_name, attr={}):
        fobj = open(self.path)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        tags = soup.findAll(tag_name, attr)
        return tags
    
    def set_backlog_link(self):
        fobj = open(self.path)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        tag = soup.find("div", {"id":"tabs"})
        title1 = soup.new_tag("h1")
        title1.append("Failures Backlog History Link")
        title2 = soup.new_tag("h1")
        title2.append("Execution Chart")
        title3 = soup.new_tag("h1")
        title3.append("Output Log Link")
        link = soup.new_tag("a")
        link.attrs = {"href":"backlog.html", "target":"_blank"}
        link.append("Failures Backlog History")
        link1 = soup.new_tag("a")
        link1.attrs = {"href":"output.html", "target":"_blank"}
        link1.append("Output Log")
        tag.insert_after(soup.new_tag("br"))
        tag.insert_after(title2)
        tag.insert_after(soup.new_tag("br"))
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
        fobj = open(r"..\hyperion\build\log\Android_Automation_Log.log")
        data1 = fobj.readlines()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        tag = soup.find("pre")
        i = 0
        while (i < len(data1)):
            if data1[i].find("[StackTrace Start]") != -1:
                temp_list = []
                while(i < len(data1)):
                    temp_list.append(data1[i])
                    i = i + 1
                    if data1[i - 1].find("[StackTrace End]") != -1:
                        tag.append(self.create_toggle_tag(temp_list, soup, i))
                        break
            if i < len(data1):
                tag.append(data1[i])
            i = i + 1
        fobj = file(self.path, "w");
        fobj.write(str(soup));
        fobj.close();
    
    def create_toggle_tag(self, data, soup, index):
        root_tag = soup.new_tag("div")
        root_tag.attrs = {"class":"element-header", "onclick":"myclick(" + str(index) + ")"}
        tag1 = soup.new_tag("div")
        tag1.attrs = {"class":"element-header-left"}
        tag1.append(data[0])
        tag2 = soup.new_tag("div")
        tag2.attrs = {"class":"element-header-toggle-close", "id":"moredetail" + str(index)}
        tag3 = soup.new_tag("div")
        tag3.attrs = {"style":"display:none;", "id":"detail" + str(index)}
        tag4 = soup.new_tag("pre")
        tag4.attrs = {"style":"color:red;"}
        for i in range(len(data)):
            if i > 1:
                tag4.append(data[i])
        tag3.append(tag4)
        root_tag.append(tag1)
        root_tag.append(tag2)
        root_tag.append(tag3)
        return root_tag
    
    def insert_iframe(self):
        fobj = open(self.path)
        data = fobj.read()
        fobj.close()
        soup = BeautifulSoup(data, "html.parser")
        tag0 = soup.new_tag("h2")
        tag0.insert(0, "Failures Backlog History")
        tag1 = soup.new_tag("iframe")
        tag1.attrs = {"frameborder":10, "width":1200, "height":1200, "src":"backlog.html"}
        self.insert_tag("div", tag0 , False)
        self.insert_tag("div", tag1 , False)
                       
if __name__ == '__main__' :
    import os
    # os.system(r"copy ..\..\app\build\reports\androidTests\connected\index_bk.html ..\..\app\build\reports\androidTests\connected\index.html /y")
    folder_name = r'..\..\hyperion\build\reports\androidTests\connected'
    handle = HtmlHandler(folder_name)
    #handle.excute()
    print handle._get_img_cmp_output_list("DP_999_ImgCmpDemo1")
    # handle.output_add_toggle()
    # handle.excute_staisic(data2)
    
