__author__ = 'renlec'
import os
import Common
import logging
import Utils

def find_publish_file(publish_path):
    publish_files = []

    for root, dirs, files in os.walk(publish_path):
        for filename in files:
            if  (filename.endswith(Common.TARGET_FILE_EXTENSION)) or filename.endswith('.json') or filename.endswith('.html') or filename.endswith('.css') or filename.endswith('.txt'):
                publish_file = os.path.abspath(os.path.join(root, filename))
                publish_files.append(publish_file)

    logging.debug('Publish files: {0} find in directory: {1}'.format(publish_files, publish_path))
    return publish_files


def create_s3_path(publish_file, s3_directory, aws_region):
    bucket_name = Common.S3_BUCKET_NAME
    if aws_region == Common.AWS_KOREA_REGION:
        bucket_name = Common.S3_BUCKET_NAME_KOREA

    logging.info('Using s3 bucket: {0}'.format(bucket_name))
    s3_path = 's3://' + bucket_name + '/' + s3_directory + '/' + os.path.basename(publish_file)

    logging.debug('S3 path is: {0}'.format(s3_path))
    return s3_path

def create_s3_path(s3_directory,aws_region):
    bucket_name = Common.S3_BUCKET_NAME
    if aws_region == Common.AWS_KOREA_REGION:
        bucket_name = Common.S3_BUCKET_NAME_KOREA

    logging.info('Using s3 bucket: {0}'.format(bucket_name))
    s3_path = 's3://' + bucket_name + '/' + s3_directory
    logging.debug('s3 path is: {0}'.format(s3_path))
    return s3_path

def create_s3_index(s3_path):
    logging.debug('Recursive creating index.html for s3 from path: {0}'.format(s3_path))

    index_path = s3_path[:s3_path.rfind('/')]
    while index_path != 's3://' + Common.S3_BUCKET_NAME:
        index_file = index_path + '/' + Common.S3_INDEX_FILE_NAME

        command = 'aws s3 --region ' + Common.AWS_REGION + ' cp ' + Common.S3_COMMON_INDEX_FILE + ' ' + index_file
        logging.debug('Create index.html file for: {0}'.format(index_file))
        logging.debug('Command is: {0}'.format(command))

        Utils.execute_real_time_command(command)
        index_path = index_path[:index_path.rfind('/')]


def upload_to_s3(publish_path, s3_directory, aws_region):
    logging.info('Publish file from: {0} to: {1}'.format(publish_path, s3_directory))

    publish_files = find_publish_file(publish_path)
    for publish_file in publish_files:
        s3_path = create_s3_path(publish_file, s3_directory, aws_region)
        command = 'aws s3 --region ' + aws_region + ' cp ' + publish_file + ' ' + s3_path
        logging.info('Uploading file: {0} to: {1}'.format(publish_file, s3_path))
        logging.debug('Command is: {0}'.format(command))

        Utils.execute_real_time_command(command)
        if aws_region == Common.AWS_KOREA_REGION:
            logging.info('Skipping create index.html for region: {0}'.format(aws_region))
        else:
            '''create_s3_index(s3_path)'''

def upload_to_s3_by_sync(publish_path, s3_directory,aws_region):
    logging.debug('Publish file from: {0} to :{1}'.format(publish_path,s3_directory))
    s3_path = create_s3_path(s3_directory,aws_region)
    command = 'aws s3 --region ' + aws_region + ' sync ' + publish_path + ' ' + s3_path
    logging.debug('Sync folder from: {0} to {1}'.format(publish_path,s3_directory))
    Utils.execute_real_time_command(command)