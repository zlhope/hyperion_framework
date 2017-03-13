"""
Designed by Johhny.H
imgcompare: 
1. Based on sikulixapi.jar.
2. Compare target images with references and return the similarity as some defined scales.
3. Scan images in report directory and choose which to be compared. 
4. Execute comparison process and organize returns to data structure.
"""

__author__ = "Johnny.H (jnhuang@telenavsoftware.com)"

import os, re
import subprocess

class imgcompare:
    
    def __init__(self, ref_dir="refs", output_dir=r"..\..\report\img"):
        self.ref_dir = ref_dir
        self.output_dir = output_dir
        
    def _compare_main(self, filepath1, filepath2, scale):
        args = ["java",
              "-jar",
              r"imgcompare.jar",
              r"images\input\test.png",
              r"images\reference\test.png",
              "0.8"]
        args[3] = filepath1
        args[4] = filepath2
        args[5] = scale
        result = subprocess.check_output(args)
        return result
    
    def compare_function(self, filepath1, filepath2):
        scale_list = [0.8, 0.9, 0.95, 0.999]
        for scale in scale_list:
            result = self._compare_main(filepath1, filepath2, str(scale))
            index = scale_list.index(scale)
            if result == "DISMATCH":
                if index == 0:
                    return 0
                else:
                    return scale_list[index - 1]
            elif result == "MATCH":
                if index == len(scale_list) - 1:
                    return scale_list[index]
            else:
                raise Exception("Compare error!!")
    
    def _get_output_file_dict(self, output_dir):
        output_file_list = os.listdir(output_dir)
        output_dict = {}
        for file_name in output_file_list:
            tmp = file_name.split("_")
            if len(tmp) > 1:
                case_num = tmp[1]
                if re.search('^\d{1,}$', case_num) != None:
                    if not output_dict.has_key(case_num):
                        case_imgs = [file_name]
                        output_dict[case_num] = case_imgs
                    else:
                        output_dict[case_num].append(file_name)
        return output_dict
    
    def _get_ref_file_dict(self, ref_dir):
        ref_file_list = os.listdir(ref_dir)
        ref_dict = {}
        for file_name in ref_file_list:
            tmp = file_name.split("_")
            if len(tmp) > 1:
                case_num = tmp[0]
                if re.search('^\d{1,}$', case_num) != None:
                    if not ref_dict.has_key(case_num):
                        case_imgs = [file_name]
                        ref_dict[case_num] = case_imgs
                    else:
                        ref_dict[case_num].append(file_name)
        return ref_dict
    
    def _get_final_cmp_dict(self, output_dict, ref_dict):
        result = {}
        for key in output_dict:
            if ref_dict.has_key(key):
                tmp_list = []
                output_imgs = output_dict[key]
                ref_imgs = ref_dict[key]
                for i in range(len(output_imgs)):
                    tmp_list.append(output_imgs[i].split("_", 1)[1])
                tmp_list.sort()
                ref_imgs.sort()
                if tmp_list == ref_imgs:
                    tmp_dict = {}
                    for i in range(len(output_imgs)):
                        for j in range(len(ref_imgs)):
                            if output_imgs[i].find(ref_imgs[j]) != -1:
                                tmp_dict[int(i + 1)] = [output_imgs[i], ref_imgs[j]]
                                break
                    result[key] = tmp_dict
        return result
    
    def output_ref_final_result(self):
        final_dict = self._get_final_cmp_dict(self._get_output_file_dict(self.output_dir),
                                 self._get_ref_file_dict(self.ref_dir))
        for case_num in final_dict:
            print "Start case: [" + case_num + "]"
            cmp_dict = final_dict[case_num]
            case_result = True
            for index in cmp_dict:
                output_img_path = self.output_dir + r"\\" + cmp_dict[index][0]
                ref_img_path = self.ref_dir + r"\\" + cmp_dict[index][1]
                similarity = self.compare_function(output_img_path, ref_img_path)
                cmp_dict[index].append(similarity)
                if similarity == 0 and case_result:
                    case_result = False
                print "Compare: [" + cmp_dict[index][0] + "," + cmp_dict[index][1] + "]"
                print "IMG No." + str(index) + " ,similarity is: " + str(similarity)
            cmp_dict[-1] = case_result
            print "--------------------------------"
        print final_dict
        return final_dict
        
if __name__ == '__main__':
    img = imgcompare()
    print img.compare_function(r"..\..\report\img\20160908152131_1172_3D_2.png",
                               r"..\..\report\img\20160908150702_1172_3D_2.png")
    pass
