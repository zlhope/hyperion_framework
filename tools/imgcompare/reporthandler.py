"""
Designed by Johhny.H
reporthandler: 
1. Based on warnings report file.
2. Fill comparison results to warnings report.
3. Optimize warnings report by changing some texts and styles. 
"""

__author__ = "Johnny.H (jnhuang@telenavsoftware.com)"

from bs4 import BeautifulSoup
from imgcompare import imgcompare
import os, sys
 
class reporthandler:
    def __init__(self, report_dir):
        self.report_dir = report_dir
        self.html_name = self._get_report_html_file()
        if self.html_name == None:
            self.html = None
        else:
            self.html = report_dir + r"\\" + self.html_name
        self.soup = None
        self.success = []
    
    def _read_html(self):
        fobj = open(self.html)
        data = fobj.read()
        fobj.close()
        return data
    
    def _write_html(self):
        fobj = file(self.html, "w");
        fobj.write(str(self.soup));
        fobj.close();
    
    def fill_table_row(self, img_dict):
        data = self._read_html()
        self.soup = BeautifulSoup(data, "html.parser")
        tr_tags = self.soup.find_all("tr")
        for tag in tr_tags:
            tds = tag.find_all("td")
            if len(tds) == 3 and tds[1].string == "TODO" and tds[2].string == "TODO":
                img_name = tds[0].a.string
                case_id = img_name.split("_")[1]
                if img_dict.has_key(case_id):
                    for key in img_dict[case_id]:
                        if key == -1:
                            continue
                        if img_dict[case_id][key][0] == img_name:
                            self._rewrite_tr_tag(tag, img_dict[case_id][key])
    
    def _rewrite_tr_tag(self, tr, data_list):
        tds = tr.find_all("td")
        img_tag = self.soup.new_tag("img")
        img_tag.attrs = {"src":"refs/" + data_list[1], "width":"360px"}
        atag = self.soup.new_tag("a")
        atag.insert(0, data_list[1])
        tds[1].string = ""
        tds[1].append(img_tag)
        tds[1].append(self.soup.new_tag("br"))
        tds[1].append(atag)
        p_tag = self.soup.new_tag("p")
        if data_list[2] > 0:
            p_tag.attrs = {"style":"color:green;font-weight:bold"}
        else:
            p_tag.attrs = {"style":"color:red;font-weight:bold"}
        p_tag.string = str(data_list[2] * 100) + "%"
        tds[2].string = ""
        tds[2].append(p_tag)
        self._write_html()
    
    
    def _get_report_html_file(self):
        for file_name in os.listdir(self.report_dir):
            if file_name.find("ImgCmp") != -1:
                return file_name
        
    def rewrite_result(self):
        data = self._read_html()
        self.soup = BeautifulSoup(data, "html.parser")
        tab_tags = self.soup.find("h2", text="Failed tests")
        tab_tags.string = "Comparison results"
        table_tags = self.soup.find_all("table")
        for table in table_tags:
            if table.tr.th == None:
                continue
            if table.tr.th.string == "Screen Shooting":
                result = True
                trs = table.find_all("tr")
                for tr in trs:
                    tds = tr.find_all("td")
                    if len(tds) == 3:
                        if tds[2].p == None:
                            result = False
                            break
                        value = tds[2].p.string
                        if value == "0%":
                            result = False
                            break
                if result and len(trs) != 0:
                    h3 = table.find_previous("h3")
                    h3.attrs = {"class": "success"}
                    self.success.append(str(h3.string))
                    h3.string = h3.string + " [Pass]"
        if len(self.success) == 0:
            self._write_html()
            return
        self._rewirte_info_box()
        for tr_t in table_tags[-1].find_all("tr"):
            if tr_t.td == None:
                continue
            if str(tr_t.td.string) in self.success:
                tmp = tr_t.find("td", {"class":"failures"})
                tmp.attrs = {"class":"success"}
                tmp.string = str(tmp.string).replace("failed", "passed")
        self._write_html()
        self._rewirte_each_html()
    
    def _rewirte_info_box(self):
        failures = self.soup.find("div", {"class" :"infoBox", "id":"failures"})
        failures = failures.find("div", {"class" :"counter"})
        failures.string = str(int(failures.string) - len(self.success))
        failures = str(failures.string)
        tests = self.soup.find("div", {"class" :"infoBox", "id":"tests"})
        tests = tests.find("div", {"class" :"counter"})
        tests = str(tests.string)
        percent_div = self.soup.find("div", {"id":"successRate"})
        percent = percent_div.find("div", {"class" :"percent"})
        percent_str = str(int(float((int(tests) - int(failures)) / float(tests)) * 100)) + "%"
        if percent_str == "100%":
            percent_div.attrs = {"class":"infoBox success", "id":"successRate"}
        percent.string = percent_str
    
    def _rewrite_sign(self):
        div_tag = self.soup.find("div", {"id" :"footer"})
        div_tag.p.a.attrs = { "href": "https://github.com/jnhyperion"}
        div_tag.p.a.string = "Johnny.H (jnhuang@telenavsoftware.com)"
                        
    def _rewirte_each_html(self):
        for file_name in os.listdir(self.report_dir):
            if file_name.endswith(r".html"):
                self.html = self.report_dir + r"\\" + file_name
                data = self._read_html()
                self.soup = BeautifulSoup(data, "html.parser")
                self._rewrite_sign()
                if (file_name != self.html_name):
                    self._rewirte_test_info()
                    self._rewirte_package_info()
                    self._rewirte_classes_info()
                self._write_html()
        
    def _rewirte_test_info(self):
        test_tag = self.soup.find("h2", text="Failed tests")
        class_tag = self.soup.find("h2", text="Classes")
        if test_tag == None or class_tag == None:
            return
        flag = False
        trs = test_tag.find_next("table").find_all("tr")
        for tr in trs:
            if (tr.td != None) and (tr.td.a != None):
                if tr.find_all("td")[1].a.string in self.success:
                    flag = True
                    tr.extract()
        if flag:
            self._rewirte_info_box()
            
    def _rewirte_package_info(self):
        pkg_tag = self.soup.find("h2", text="Packages")
        if pkg_tag == None:
            return
        trs = pkg_tag.find_next("table").find_all("tr")
        for tr in trs:
            if (tr.td != None) and (tr.td.a != None):
                if self.html_name.find(str(tr.td.a.string)) != -1:
                    tds = tr.find_all("td")
                    tds[2].string = str(int(tds[2].string) - len(self.success))
                    tds[4].string = str(int(float((int(tds[1].string) - int(tds[2].string)) / float(tds[1].string)) * 100)) + "%"
                    if tds[4].string == "100%":
                        tds[4].attrs = {"class":"success"}
                        tds[0].attrs = {"class":"success"}
    
    def _rewirte_classes_info(self):
        class_tag = self.soup.find("h2", text="Classes")
        if class_tag == None:
            return
        trs = class_tag.find_next("table").find_all("tr")
        for tr in trs:
            if (tr.td != None) and (tr.td.a != None):
                if tr.td.a.attrs["href"] == self.html_name:
                    tds = tr.find_all("td")
                    tds[2].string = str(int(tds[2].string) - len(self.success))
                    tds[4].string = str(int(float((int(tds[1].string) - int(tds[2].string)) / float(tds[1].string)) * 100)) + "%"
                    if tds[4].string == "100%":
                        tds[4].attrs = {"class":"success"}
                        tds[0].attrs = {"class":"success"}
                        
    def rewrite_EC_property(self, on_off_flag="true"):
        if os.path.exists(self.report_dir + "\\index.html"):
            linelist = open(self.report_dir + "\\index.html").readlines()
            for i in range(len(linelist)):
                if linelist[i].find('<div class="infoBox" id="tests">') != -1:
                    testcount = linelist[i + 1].split("</")[0].split(">")[-1]
                if linelist[i].find('<div class="infoBox" id="failures">') != -1:
                    failures = linelist[i + 1].split("</")[0].split(">")[-1]
                if linelist[i].find('<div class="infoBox" id="duration">') != -1:
                    duration = linelist[i + 1].split("</")[0].split(">")[-1]
                if linelist[i].find('id="successRate">') != -1:
                    successrate = linelist[i + 1].split("</")[0].split(">")[-1]
            if on_off_flag == "true":
                os.system("ectool setProperty /myJob/off_total " + testcount)
                os.system("ectool setProperty /myJob/off_failures " + failures)
                os.system("ectool setProperty /myJob/off_time " + duration)
                os.system("ectool setProperty /myJob/off_percentage " + successrate)
            else:
                os.system("ectool setProperty /myJob/on_total " + testcount)
                os.system("ectool setProperty /myJob/on_failures " + failures)
                os.system("ectool setProperty /myJob/on_time " + duration)
                os.system("ectool setProperty /myJob/on_percentage " + successrate)
              
if __name__ == '__main__' :
    report_dir = r"..\..\hyperion\build\reports\androidTests\connected"
    imgc = imgcompare(output_dir=report_dir + r"\img")
    final_result = imgc.output_ref_final_result()
    if not os.path.exists(report_dir + "_bk"):
        os.system(r"xcopy " + report_dir + " " + report_dir + "_bk\\" + r" /s/e/y/q")
    else:
        os.system(r"rd " + report_dir + r" /q/s")
        os.system(r"xcopy " + report_dir + "_bk " + report_dir + "\\" + r" /s/e/y/q")
    os.system(r"xcopy .\refs " + report_dir + "\\refs\ /s/e/y/q")
    # final_result = {'997': {1: ['20170110233500_997_DEMO1.png', '997_DEMO1.png', 0.999], 2: ['20170110233501_997_DEMO2.png', '997_DEMO2.png', 0.999], 3: ['20170110233501_997_DEMO3.png', '997_DEMO3.png', 0.999], 4: ['20170110233502_997_DEMO4.png', '997_DEMO4.png', 0.999], -1: True}, '999': {1: ['20170110233438_999_DEMO.png', '999_DEMO.png', 0.999], -1: True}}
    handle = reporthandler(report_dir)
    if handle.html == None:
        print "Cannot find IMG CMP HTML file, process terminated!!!"
        sys.exit(0)
    handle.fill_table_row(final_result)
    handle.rewrite_result()
    try:
        on_off_flag = sys.argv[1]
    except:
        on_off_flag = "true"
    handle.rewrite_EC_property(on_off_flag)
