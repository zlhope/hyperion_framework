import argparse
import logging
import Utils
import Common
import S3Operator

def parse_args():
    parser = argparse.ArgumentParser(description='Upload to AWS S3.')
    parser.add_argument('--s3_directory', required=True, help='S3 Directory to save the file.')
    parser.add_argument('--publish_path', required=True, help='Publish folder to save final data.')
    parser.add_argument('--aws_region', required=False, help='AWS region to upload.', choices=[Common.AWS_REGION, Common.AWS_KOREA_REGION], default=Common.AWS_REGION)
    parser.add_argument('--log_level', help='Log Output Level', choices=['DEBUG', 'INFO', 'ERROR'], default='DEBUG')
    args = parser.parse_args()
    return args


if __name__ == '__main__':
    args = parse_args()
    log_level = args.log_level

    Utils.log_configuration(log_level)
    logging.info('Input Parameters: {0}'.format(args))

    publish_path = args.publish_path
    s3_directory = args.s3_directory.strip('\/')
    aws_region = args.aws_region

    S3Operator.upload_to_s3_by_sync(publish_path, s3_directory, aws_region)