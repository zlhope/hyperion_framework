import os
import sys
import logging
import platform

import Utils

JAVA_TOOL = 'java -Xms128m -Xmx2g -XX:PermSize=128m -XX:MaxPermSize=256m -jar '
DATA_TOOL_WIN = 'Data_Package.exe'
DATA_TOOL_LINUX = 'Data_Package'

if platform.system() is 'Windows':
    DATA_TOOL = os.path.join('tools', DATA_TOOL_WIN)
else:
    DATA_TOOL = os.path.join('tools', DATA_TOOL_LINUX)

DATA_TOOL_ERROR_MESSAGES = ['error', 'core dumped']
NAVTEQ_RASTERIZER_TOOL = os.path.join('tools', 'NAVTEQRasterizer.jar')

ASPECT_RATIO_DIRECTORY_NAME = 'ASPECT_RATIO_'

JV_DAY_DIRECTORY_NAME = 'day'
JV_NIGHT_DIRECTORY_NAME = 'night'
JV_ARROW_M_DIRECTORY_NAME = 'arrow_m'
SIGN_FULL_DIRECTORY_NAME = 'full'
SIGN_SUB_DIRECTORY_NAME = 'sub'

PACKAGE_EXTENSION = '.pkg'
EJV = 'ejv'
SAR = 'sar'
SVG = 'svg'

SAR_META_FILE_NAME = 'meta_file.meta'

GJV_DIRECTORY_NAME = 'COMMON'
GJV_FILE_NAME = 'gjv.pkg'

FINAL_DIRECTORY_NAME = 'junction'

VERSION_FILE_NAME = 'version.txt'
MANIFEST_FILE_NAME = 'md5manifest.txt'

TARGET_FILE_PREFIX = 'junction_data'
TARGET_FILE_PREFIX_DELTA = 'junction_data_delta'
TARGET_FILE_EXTENSION = '.tar.gz'

S3_INDEX_FILE_NAME = 'index.html'
S3_BUCKET_NAME = 'tactaws.telenav.com'
S3_BUCKET_NAME_KOREA = 'gmkorea-data'
S3_COMMON_INDEX_FILE = 's3://' + S3_BUCKET_NAME + '/common/' + S3_INDEX_FILE_NAME

DEFAULT_ENCODING = 'utf-8'

REPORT_CSS = os.path.join('report', 'style.css')

PBF_EXTENSION = '.pbf'

SPACE_ID_MAPPING = os.path.join('tools', 'space_id_mapping.csv')

# Some region's data include with others, so we need only part of the source data.
SPECIAL_REGIONS = {'TUR': 'TURKEY', 'ISRAEL': 'ISRAEL'}

# Korea pattern
JV_DAY_DIRECTORY_NAME_KOREA = 'DAY'
JV_NIGHT_DIRECTORY_NAME_KOREA = 'NIGHT'
JV_PKG_FILENAME = 'junction.pkg'

# Default AWS Region
AWS_REGION = 'us-west-2'
AWS_KOREA_REGION = 'ap-northeast-2'


def get_pngquant_tool():
    os_type = platform.system()
    if os_type is 'Windows':
        pngquant_tool = os.path.join(Utils.get_execute_dir(), 'tools', 'pngquant.exe')
    else:
        pngquant_tool = 'pngquant'

    logging.debug('For OS: {0} tools is: {1}'.format(os_type, pngquant_tool))
    return pngquant_tool


def get_pixel_ratio_mapping(pixel_size):
    pixel_mapping = {'400x480': '4x3', '400x666': '3x5', '640x480': '4x3'}

    ratio = pixel_mapping[pixel_size]
    logging.info('pixel_size: {0} mapping to: {1}'.format(pixel_size, ratio))
    return ratio


def get_wt_from_pixel(pixel_size):
    wt = pixel_size.split('x')[0]
    logging.info('Pixel wt is: {0}'.format(wt))
    return wt


def get_ht_from_pixel(pixel_size):
    ht = pixel_size.split('x')[1]
    logging.info('Pixel ht is: {0}'.format(ht))
    return ht


def get_file_count(directory, extensions):
    count = 0
    for root, dirs, files in os.walk(directory):
        for filename in files:
            if filename.endswith(extensions):
                count = count + 1

    logging.info('Directory: {0} contains: {1} {2} files.'.format(directory, count, extensions))
    return count


def check_output(output):
    logging.debug('Checking command output: {0}'.format(output))
    for error_message in DATA_TOOL_ERROR_MESSAGES:
        logging.info('Searching message: {0} in log.'.format(error_message))
        if error_message in output:
            logging.error('Error: {0} found in data tool. Program will exist!'.format(error_message))
            logging.error('Error log: {0}'.format(output))
            sys.exit(1)

    logging.info('Command log looks like normally.')
